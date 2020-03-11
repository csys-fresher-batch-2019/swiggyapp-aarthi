package swiggyhotel.dao.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import swiggyhotel.model.FoodDetails;

public class AllFoodItemsRowMapper implements RowMapper<FoodDetails> {

	@Override
	public FoodDetails map(ResultSet rs, StatementContext ctx) throws SQLException {
		FoodDetails food = new FoodDetails();
		food.setItemId(rs.getInt("item_id"));
		food.setItemName(rs.getString("item_Name"));
		food.setFoodType(rs.getString("food_type"));
		food.setPrice(rs.getInt("price"));
		food.setMenuId(rs.getInt("menu_id"));
		food.setImages(rs.getString("images"));
		return food;
	}

}
