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
	private int saldoCompras;
	
	public Cliente() {
		
	}
	
	public Cliente(String nombreCli, long telefono, String email, String fechaCreacion, int saldoCompras) {
		super();
		this.nombreCli = nombreCli;
		this.telefono = telefono;
		this.email = email;
		this.fechaCreacion = fechaCreacion;
		this.saldoCompras = saldoCompras;
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

	public int getSaldoCompras() {
		return saldoCompras;
	}

	public void setSaldoCompras(int saldoCompras) {
		this.saldoCompras = saldoCompras;
	}
	
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombreCli=" + nombreCli + ", telefono=" + telefono + ", email="
				+ email + ", fechaCreacion=" + fechaCreacion + ", saldoCompras=" + saldoCompras + "]";
	}
}
