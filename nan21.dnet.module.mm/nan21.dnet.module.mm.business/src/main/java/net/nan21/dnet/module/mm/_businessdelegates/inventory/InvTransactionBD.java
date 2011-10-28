package net.nan21.dnet.module.mm._businessdelegates.inventory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;  
import java.util.List;

import org.eclipse.persistence.config.CacheUsage;
import org.eclipse.persistence.config.QueryHints;

import net.nan21.dnet.core.business.service.AbstractBusinessDelegate; 
import net.nan21.dnet.module.mm.inventory.domain.entity.InvOperation;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransaction;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionLine;

public class InvTransactionBD  extends AbstractBusinessDelegate {

	public void postTransaction(Long transactionId ) throws Exception {
//		InvTransaction transaction = (InvTransaction) this.em.createNamedQuery(InvTransaction.NQ_FIND_BY_ID)
//			.setParameter("pId", transactionId)
//			.setHint(QueryHints.LOAD_GROUP_ATTRIBUTE, "lines")
//			.setHint(QueryHints.CACHE_USAGE, CacheUsage.DoNotCheckCache)
//			.getResultList().get(0);

		InvTransaction transaction = (InvTransaction) this.em.createNamedQuery(InvTransaction.NQ_FIND_BY_ID)
		.setParameter("pId", transactionId)		 
		.getResultList().get(0);
		
		if (transaction == null ) {
			throw new Exception("Transaction with ID="+transactionId+" not found!");
		}
		if (transaction.getEventDate() != null) {
			throw new Exception("Transaction with ID="+transactionId+" is already posted!");
		}
		 
		transaction.setEventDate(new Date());
		this.createOperations(transaction);
		this.em.merge(transaction);
		
	}
	
	
	private void createOperations(InvTransaction transaction) {
		
		
		List<InvTransactionLine> lines = this.em.createQuery("select e from InvTransactionLine e where e.invTransaction.id = :pTxId")
		.setParameter("pTxId", transaction.getId())
		.getResultList();
		 
		for(InvTransactionLine line: lines) {
			
			// create out operation from source 
			if (transaction.getFromInventory() != null ) {
				InvOperation op = new InvOperation();
				op.setEventDate(transaction.getEventDate());
				op.setItem(line.getItem());
				op.setInventory(transaction.getFromInventory());
				op.setSubInventory(line.getFromSubInventory());
				op.setLocator(line.getFromLocator());
				op.setQuantity(line.getQuantity());
				op.setTransactionLine(line);
				op.setDirection("out");
				//operations.add(op);
				this.em.persist(op);
			}
			
			// create out operation from source 
			if (transaction.getToInventory() != null ) {
				InvOperation op = new InvOperation();
				op.setEventDate(transaction.getEventDate());
				op.setItem(line.getItem());
				op.setInventory(transaction.getToInventory());
				op.setSubInventory(line.getToSubInventory());
				op.setLocator(line.getToLocator());
				op.setQuantity(line.getQuantity());
				op.setTransactionLine(line);
				op.setDirection("in");
				//operations.add(op);
				this.em.persist(op);
			}	
			
		}
		 
	}
}
