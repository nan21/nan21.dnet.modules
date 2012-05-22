package net.nan21.dnet.module.md._businessdelegates.mm.inventory;

import java.util.Date;
import java.util.List;

import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.org.domain.entity.SubInventory;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvBalance;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvOperation;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransaction;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionLine;
 

public class InvTransactionBD extends AbstractBusinessDelegate {

	protected TypedQuery<InvBalance> balanceQuery;

	public void confirm(Long transactionId) throws Exception {
		InvTransaction transaction = (InvTransaction) this.em.createNamedQuery(
				InvTransaction.NQ_FIND_BY_ID).setParameter("pClientId",
				Session.user.get().getClientId()).setParameter("pId",
				transactionId).getResultList().get(0);

		if (transaction == null) {
			throw new RuntimeException("Transaction with ID=" + transactionId
					+ " not found!");
		}
		if (transaction.getConfirmed()) {
			throw new RuntimeException("Transaction with ID=" + transactionId
					+ " is already confirmed!");
		}

		String stockEql = "select e from InvBalance e "
			+ " where e.clientId = :pClientId "
			+ "   and e.subInventory.id = :pSubInventoryId"
			+ "   and e.item.id = :pItemId";
		this.balanceQuery = this.em.createQuery(stockEql, InvBalance.class);
	
		transaction.setEventDate(new Date());
		this.createOperations(transaction);
		transaction.setConfirmed(true);
		this.em.merge(transaction);
	}

	public void unConfirm(Long transactionId) throws Exception {
		InvTransaction transaction = (InvTransaction) this.em.createNamedQuery(
				InvTransaction.NQ_FIND_BY_ID).setParameter("pClientId",
				Session.user.get().getClientId()).setParameter("pId",
				transactionId).getResultList().get(0);

		if (transaction == null) {
			throw new RuntimeException("Transaction with ID=" + transactionId
					+ " not found!");
		}

		// transaction.setEventDate(new Date());

		// get operations to update balance

		String stockEql = "select e from InvBalance e "
			+ " where e.clientId = :pClientId "
			+ "   and e.subInventory.id = :pSubInventoryId"
			+ "   and e.item.id = :pItemId";
		this.balanceQuery = this.em.createQuery(stockEql, InvBalance.class);
	
	
		String eql = "select e from InvOperation e "
				+ " where e.clientId = :pClientId "
				+ "  and e.transactionLine.id in "
				+ "	(select t.id from InvTransactionLine t where t.invTransaction.id = :pTxId) ";
		List<InvOperation> operations = this.em.createQuery(eql,
				InvOperation.class).setParameter("pTxId", transaction.getId())
				.setParameter("pClientId", Session.user.get().getClientId())
				.getResultList();

		for (InvOperation operation : operations) {
			this.updateBalance(operation.getItem(),
					operation.getSubInventory(), operation.getQuantity(), null,
					operation.getDirection().equals("out"));
		}
 
		// delete from operations ....

		eql = "delete from InvOperation e "
				+ " where e.clientId = :pClientId "
				+ "   and e.transactionLine.id in "
				+ "	(select t.id from InvTransactionLine t where t.invTransaction.id = :pTxId) ";
		this.em.createQuery(eql).setParameter("pTxId", transaction.getId())
				.setParameter("pClientId", Session.user.get().getClientId())
				.executeUpdate();

		transaction.setConfirmed(false);
		transaction.setEventDate(null);
		this.em.merge(transaction);
	}

	private void createOperations(InvTransaction transaction) throws Exception {

		List<InvTransactionLine> lines = this.em
				.createQuery(
						"select e from InvTransactionLine e where e.invTransaction.id = :pTxId and e.clientId = :pClientId",
						InvTransactionLine.class).setParameter("pTxId",
						transaction.getId()).setParameter("pClientId",
						Session.user.get().getClientId()).getResultList();
		
		for (InvTransactionLine line : lines) {
			
			if (line.getFromSubInventory() != null && line.getToSubInventory() != null
					&& line.getFromSubInventory().getId() == line.getToSubInventory().getId()) {
				throw new RuntimeException("Invalid movement, source and target sub-inventories are the same: "+line.getFromSubInventory().getName());
			}
			
			// create out operation from source
			if (transaction.getFromInventory() != null) {
				InvOperation op = new InvOperation();
				if (line.getFromSubInventory() == null) {					
					throw new RuntimeException("Cannot create movement for product with code "+line.getItem().getCode()+". No source sub-inventory specified.  ");
				}
				op.setEventDate(new Date());
				op.setItem(line.getItem());
				op.setInventory(transaction.getFromInventory());
				op.setSubInventory(line.getFromSubInventory());
				op.setLocator(line.getFromLocator());
				op.setQuantity(line.getQuantity());
				op.setTransactionLine(line);
				
				//TODO:  check uom and convert it
				op.setUom(line.getUom());
				op.setDirection("out");
				// operations.add(op);
				
				this.updateBalance(op.getItem(), op.getSubInventory(), op
						.getQuantity(), line.getUom(), false);
				this.em.persist(op);
			}

			// create out operation from source
			if (transaction.getToInventory() != null) {
				InvOperation op = new InvOperation();
				if (line.getToSubInventory() == null) {					
					throw new RuntimeException("Cannot create movement for product with code "+line.getItem().getCode()+". No target sub-inventory specified.  ");
				}
				op.setEventDate(new Date());
				op.setItem(line.getItem());
				op.setInventory(transaction.getToInventory());
				op.setSubInventory(line.getToSubInventory());
				op.setLocator(line.getToLocator());
				op.setQuantity(line.getQuantity());
				//TODO:  check uom and convert it
				op.setUom(line.getUom());
				op.setTransactionLine(line);
				op.setDirection("in");
				// operations.add(op);
				
				this.updateBalance(op.getItem(), op.getSubInventory(), op
						.getQuantity(), line.getUom(), true);
				this.em.persist(op);
			}
			
			// find balance for sub-inventory/product/uom
 		}

	}

	private void updateBalance(Product item, SubInventory subInventory,
			Float quantity, Uom uom, boolean addition) throws Exception {
		InvBalance stock = null;

		List<InvBalance> stocks = this.balanceQuery.setParameter("pClientId",
				Session.user.get().getClientId()).setParameter(
				"pSubInventoryId", subInventory.getId()).setParameter(
				"pItemId", item.getId()).getResultList();
		boolean exists = stocks.size() > 0;

		// lock stock if exists

		if (!exists) {
			stock = new InvBalance();
			stock.setItem(item);
			stock.setSubInventory(subInventory);
			stock.setUom(uom);
			stock.setQuantity(0F);
		} else {
			stock = stocks.get(0);
			this.em.lock(stock, LockModeType.PESSIMISTIC_READ);
		}
		// update quantity

		if (addition) {
			stock.setQuantity(stock.getQuantity() + quantity);
		} else {
			Float q = stock.getQuantity() - quantity;
			if (q<0){
				throw new RuntimeException("Insufficient stock for "+item.getCode()+ " in sub-inventory " + subInventory.getName()+". Maximum available is " + stock.getQuantity() );
			}
			stock.setQuantity(q);
		}

		// save stock

		if (!exists) {
			this.em.persist(stock);
		} else {
			this.em.merge(stock);
		}

	}

}
