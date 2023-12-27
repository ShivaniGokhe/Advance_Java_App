package in.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.connection.ConnectionFactory;
import in.dto.ProdDTO;

public class ProdDao {

	public boolean saveProd(ProdDTO p) {
		boolean isSaved = false;

		String sql = "insert into Product_dtl(Product_Name,Product_Price,Product_Qty) values(?,?,?)";
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p.getProdName());
			pstmt.setInt(2, p.getProdPrice());
			pstmt.setInt(3, p.getProdQty());

			int count = pstmt.executeUpdate();
			if (count > 0) {
				isSaved = true; // Data Inserted Successfully
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSaved;
	}

	public List<ProdDTO> getProds(Integer prodId) {
		List<ProdDTO> prods = new ArrayList<>();
		StringBuilder sql = new StringBuilder("select * from product_dtl");
		try {
			Connection con = ConnectionFactory.getConnection();

			if (prodId != null) {
				sql.append(" where product_id = ?");
			}
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			if (prodId != null) {
				pstmt.setInt(1, prodId);
			}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				// adding result obj to dto
				ProdDTO dto = new ProdDTO();
				dto.setProdId(rs.getInt("Product_Id"));
				dto.setProdName(rs.getString("Product_Name"));
				dto.setProdPrice(rs.getInt("Product_Price"));
				dto.setProdQty(rs.getInt("Product_Qty"));

				// adding dto obj to collection
				prods.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prods;
	}

}
