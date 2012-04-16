package net.nan21.dnet.module.ad._domainext;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@MappedSuperclass
public abstract class AbstractTypeWithCode {

	public static final String SEQUENCE_NAME = "_SEQ";

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	protected Long id;

	/**
	 * Code of entity.
	 */
	@Column(name = "CODE", nullable = false, length = 32)
	@NotBlank
	private String code;

	/**
	 * Name of entity.
	 */
	@Column(name = "NAME", nullable = false, length = 255)
	@NotBlank
	protected String name;

	/**
	 * Flag which indicates if this record is actively used.
	 */
	@Column(name = "ACTIVE", nullable = false)
	@NotNull
	protected Boolean active;

	/**
	 * Notes about this record.
	 */
	@Column(name = "NOTES", length = 4000)
	private String notes;

	/** Owner client */
	@Column(name = "CLIENTID", nullable = false)
	@NotNull
	protected Long clientId;

	/** Timestamp when this record was created. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDAT", nullable = false)
	@NotNull
	protected Date createdAt;

	/** Timestamp when this record was last modified. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIEDAT", nullable = false)
	@NotNull
	protected Date modifiedAt;

	/** User who created this record. */
	@Column(name = "CREATEDBY", nullable = false, length = 32)
	@NotBlank
	protected String createdBy;

	/** User who last modified this record. */
	@Column(name = "MODIFIEDBY", nullable = false, length = 32)
	@NotBlank
	protected String modifiedBy;

	@Version
	/** Record version number used by the persistence framework. */
	@Column(name = "VERSION", nullable = false)
	@NotNull
	protected Long version;

	/**
	 * System generated UID. Useful for data import-export and data-replication
	 */
	@Column(name = "UUID", length = 36)
	protected String uuid;

	@Transient
	public String getClassName() {
		return this.getClass().getCanonicalName();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
