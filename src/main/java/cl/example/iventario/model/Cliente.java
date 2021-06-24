package cl.example.iventario.model;


import javax.persistence.*;

@Entity
@Table(name="clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idcliente") 
	private long idCliente;

	@Column(name="nombrecli")
	private String nombreCli;
	
	@Column(name="telefono")
	private long telefono;
	
	@Column(name="email")
	private String email;
	
	@Column(name="fechacreacion")
	private String fechaCreacion;
	
	@Column(name="saldocompras")
	private float saldoCompras;
	
	@Column(name="descuento")
	private int descuento;

	public Cliente() {
		
	}
	
	public Cliente(String nombreCli, long telefono, String email, String fechaCreacion, float saldoCompras, int descuento) {
		super();
		this.nombreCli = nombreCli;
		this.telefono = telefono;
		this.email = email;
		this.fechaCreacion = fechaCreacion;
		this.saldoCompras = saldoCompras;
		this.descuento = descuento;
	}
	
	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCli() {
		return nombreCli;
	}

	public void setNombreCli(String nombreCli) {
		this.nombreCli = nombreCli;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public float getSaldoCompras() {
		return saldoCompras;
	}

	public void setSaldoCompras(float saldoCompras) {
		this.saldoCompras = saldoCompras;
	}
	
	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombreCli=" + nombreCli + ", telefono=" + telefono + ", email="
				+ email + ", fechaCreacion=" + fechaCreacion + ", saldoCompras=" + saldoCompras + ", descuento="
				+ descuento + "]";
	}
	
	
}
