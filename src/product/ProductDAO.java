package Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;



public class ProductDAO {
	private ProductDAO() {
	}

	private static ProductDAO instance = new ProductDAO();

	public static ProductDAO getInstance() {
		return instance;
	}

	public List<ProductVO> selectAll() {
		List<ProductVO> list = new ArrayList<>();
		Pattern pattern = Pattern.compile(",");

		try(BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\OWNER\\workspace\\algorithm-study\\src\\Product\\2017_be_sheet.csv"))){

			 list = in.lines().map(line -> {
				String[] x = pattern.split(line);
				return new ProductVO(x[0], Integer.parseInt(x[1]), Integer.parseInt(x[2]), Integer.parseInt(x[3]));
			}).collect(Collectors.toList());
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

		return list;
	}
	
	public List<ProductVO> selectBestPrice() {
		List<ProductVO> list = selectAll();
		List<ProductVO> newList = new ArrayList<>();
		List<ProductVO> bestList = new ArrayList<>();

		
		for(int i=0; i<list.size(); i++) {
			ProductVO product = list.get(i);
			int turnover = product.getSellingPrice() * product.getQuantity();
			int rate = ((product.getNormalPrice() - product.getSellingPrice()) / product.getSellingPrice()) * 100;
			newList.add(new ProductVO(turnover, product.getProductName(), product.getNormalPrice(), product.getSellingPrice(), rate));
		}
		
		for(int i=0; i<list.size(); i++) {
			ProductVO product = newList.get(i);
			for(int j=1; j<list.size() - 1; j++) {
				ProductVO tmpProduct = newList.get(j);
				if(product.getTurnover() > tmpProduct.getTurnover()) {
					ProductVO tmpProduct2 = tmpProduct;
					tmpProduct = product;
					product = tmpProduct2;
				}
			}
		}
		
		return bestList;
	}

}
