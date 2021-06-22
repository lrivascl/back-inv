package cl.example.iventario.model;


import javax.persistence.*;

@Entity
@Table(name="transacciones")
public class Transaccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idtrx") 
	private long idTrx;

	@Column(name="trx")
	private String trx;

	@Column(name= "name")
	private String name;

	@Column(name="unidades")
	private int unidades;
	
	@Column(name="codigoproducto")
	private long codigoProducto;

	@Column(name="precio")
	private int precio;
	
	@Column(name="fechatrx")
	private String fechaTrx;
	
	public Transaccion () {
		
	}
	
	public Transaccion(String trx,String name,long codigoProducto, int unidades, int precio, String fechaTrx) {
		super();
		this.trx = trx;
		this.name = name;
		this.codigoProducto = codigoProducto;
		this.unidades = unidades;
		this.precio = precio;
		this.fechaTrx = fechaTrx;
	}
	
	public long getIdTrx() {
		return idTrx;
	}

	public void setIdTrx(long idTrx) {
		this.idTrx = idTrx;
	}

	public String getTrx() {
		return trx;
	}

	public void setTrx(String trx) {
		this.trx = trx;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public long getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getFechaTrx() {
		return fechaTrx;
	}

	public void setFechaTrx(String fechaTrx) {
		this.fechaTrx = fechaTrx;
	}
	
	@Override
	public String toString() {
		return "Transaccion [idTrx=" + idTrx + ", trx=" + trx + ", name=" + name + ", unidades=" + unidades
				+ ", codigoProducto=" + codigoProducto + ", precio=" + precio + ", fechaTrx=" + fechaTrx + "]";
	}


}

