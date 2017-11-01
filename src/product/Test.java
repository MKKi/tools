package Product;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import util.CSVParser;

public class Test {
	
    
	public static void main(String[] args) {
		ProductDAO dao = ProductDAO.getInstance();

		List<ProductVO> list = new ArrayList<>();
		String fileName = "C:\\Users\\OWNER\\workspace\\algorithm-study\\src\\Product\\2017_be_sheet.csv";

		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "EUC-KR"))) {

			list = in.lines().map(line -> {
				List<String> item = CSVParser.parseLine(line);
				
				System.out.println( item.get(0) + " " + item.get(1) + "원 " + item.get(2) + "원 " + item.get(3) + "개");
				return new ProductVO(item.get(0), Integer.parseInt(item.get(1)), Integer.parseInt(item.get(2)), Integer.parseInt(item.get(3)));
			}).collect(Collectors.toList());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		for(ProductVO product : list) {
			System.out.println(product.toString());
		}
	}
	

}
