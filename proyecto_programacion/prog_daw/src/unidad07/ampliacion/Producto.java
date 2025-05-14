package unidad07.ampliacion;

public class Producto {
	private String codigo;
	private String desc;
	private Float precioCompra;
	private Float precioVenta;
	private Integer stock;

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the precioCompra
	 */
	public Float getPrecioCompra() {
		return precioCompra;
	}

	/**
	 * @param precioCompra the precioCompra to set
	 */
	public void setPrecioCompra(Float precioCompra) {
		this.precioCompra = precioCompra;
	}

	/**
	 * @return the precioVenta
	 */
	public Float getPrecioVenta() {
		return precioVenta;
	}

	/**
	 * @param precioVenta the precioVenta to set
	 */
	public void setPrecioVenta(Float precioVenta) {
		this.precioVenta = precioVenta;
	}

	/**
	 * @return the stock
	 */
	public Integer getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Producto(String codigo, String desc, Float precioCompra, Float precioVenta, Integer stock)
			throws ProductoException {
		if (checkValues(codigo, desc, precioCompra, precioVenta, stock)) {
			this.codigo = codigo;
			this.desc = desc;
			this.precioCompra = precioCompra;
			this.precioVenta = precioVenta;
			this.stock = stock;
		} else {
			throw new ProductoException("Datos erróneos en el producto");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Producto)) {
			return false;
		}
		Producto other = (Producto) obj;
		if (codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		} else if (!codigo.equals(other.codigo)) {
			return false;
		}
		return true;
	}

	private boolean checkValues(String codigo, String desc, Float precioCompra, Float precioVenta, Integer stock) {
		boolean datosOk = true;
		if (null == codigo || null == desc || null == precioCompra || null == precioVenta || null == stock) {
			datosOk = false;
		}
		if (datosOk && !codigo.matches("[A-Z][0-9]{4}")) {
			datosOk = false;
		}
		if (datosOk && null != desc && (desc.length() < 5 || desc.length() > 256)) {
			datosOk = false;
		}
		if (datosOk && (precioCompra < 0 || precioVenta < 0 || stock < 0)) {
			datosOk = false;
		}
		return datosOk;
	}

}
