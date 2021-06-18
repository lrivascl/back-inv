package cl.example.iventario.model;

import javax.persistence.*;


@Entity
@Table(name= "productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name ="codigo")
	private long codigo;
	
	@Column(name ="cantidad")
	private int cantidad;
	

	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "published")
	private boolean published;
	
	public Producto() {

	}
	
	public Producto(String nombre, long codigo,int cantidad,String descripcion, boolean published) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.published = published;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ",cantidad=" + "cantidad" + ", descripcion=" 
				+ descripcion + ", published=" + published + "]";
	}
	
	
	
}
