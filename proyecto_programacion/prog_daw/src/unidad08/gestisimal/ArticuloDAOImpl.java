/**
 * 
 */
package unidad08.gestisimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 */
public class ArticuloDAOImpl implements ArticuloDAO {
	@Override
	public void aniadir(Articulo art) {
		Connection con = DatabaseManager.getConnection();
		try {
			String sql = "insert into articulo (codigo, descripcion,precio_compra, precio_venta,stock) values (?,?,?,?,?)";
			PreparedStatement query = con.prepareStatement(sql);
			query.setString(1, art.getCodigo());
			query.setString(2, art.getDesc());
			query.setDouble(3, art.getPrecioCompra());
			query.setDouble(4, art.getPrecioVenta());
			query.setInt(5, art.getStock());
			query.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actualizar(Articulo art) {
		Connection con = DatabaseManager.getConnection();
		try {
			String sql = "update articulo set codigo = ?, descripcion = ?,precio_compra = ?, precio_venta = ? ,stock= ? where codigo = ?";
			PreparedStatement query = con.prepareStatement(sql);
			query.setString(1, art.getCodigo());
			query.setString(2, art.getDesc());
			query.setDouble(3, art.getPrecioCompra());
			query.setDouble(4, art.getPrecioVenta());
			query.setInt(5, art.getStock());
			query.setString(6, art.getCodigo());
			int ok = query.executeUpdate();
			System.out.println("inserción " + ok);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void eliminar(String codigo) {

		Connection con = DatabaseManager.getConnection();
		try {
			String sql = "delete from articulo where codigo = ?";
			PreparedStatement query = con.prepareStatement(sql);
			query.setString(1, codigo);
			// TODO terminar
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Articulo obtener(String codigo) {
		Articulo art = null;
		Connection con = DatabaseManager.getConnection();
		try {
			String sql = "select codigo, descripcion,precio_compra, precio_venta,stock from articulo where codigo = ?";
			PreparedStatement query = con.prepareStatement(sql);
			query.setString(1, codigo);
			ResultSet rs = query.executeQuery();
			if (rs.next()) {
				String cod = rs.getString("codigo");
				String desc = rs.getString("descripcion");
				Float precioCompra = rs.getFloat("precio_compra");
				Float precioVenta = rs.getFloat("precio_venta");
				Integer stock = rs.getInt("stock");
				art = new Articulo(cod, desc, precioCompra, precioVenta, stock);
			}
			con.close();
		} catch (SQLException | ArticuloException e) {
			e.printStackTrace();
		}
		return art;
	}

	@Override
	public Set<Articulo> obtenerArticulos() {
		Set<Articulo> articulos = new HashSet<Articulo>();
		Connection con = DatabaseManager.getConnection();
		try {
			String sql = "select codigo, descripcion,precio_compra, precio_venta,stock from articulo";
			PreparedStatement query = con.prepareStatement(sql);
			ResultSet rs = query.executeQuery();
			while (rs.next()) {
				String cod = rs.getString("codigo");
				String desc = rs.getString("descripcion");
				Float precioCompra = rs.getFloat("precio_compra");
				Float precioVenta = rs.getFloat("precio_venta");
				Integer stock = rs.getInt("stock");
				Articulo art = new Articulo(cod, desc, precioCompra, precioVenta, stock);
				articulos.add(art);
			}
			con.close();
		} catch (SQLException | ArticuloException e) {
			e.printStackTrace();
		}
		return articulos;

	}

	@Override
	public Set<Articulo> obtenerArticulos(String busqueda) {
		Set<Articulo> articulos = new HashSet<Articulo>();
		Connection con = DatabaseManager.getConnection();
		try {
			String sql = "select codigo, descripcion,precio_compra, precio_venta,stock from articulo where descripcion like ('%?%')";
			PreparedStatement query = con.prepareStatement(sql);
			query.setString(1, busqueda);
			ResultSet rs = query.executeQuery();
			while (rs.next()) {
				String cod = rs.getString("codigo");
				String desc = rs.getString("descripcion");
				Float precioCompra = rs.getFloat("precio_compra");
				Float precioVenta = rs.getFloat("precio_venta");
				Integer stock = rs.getInt("stock");
				Articulo art = new Articulo(cod, desc, precioCompra, precioVenta, stock);
				articulos.add(art);
			}
			con.close();
		} catch (SQLException | ArticuloException e) {
			e.printStackTrace();
		}
		return articulos;
	}

}
