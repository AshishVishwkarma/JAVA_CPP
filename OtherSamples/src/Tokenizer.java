import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Tokenizer{
	public Map<Integer, String> tokenize(String str, String delimiter){
		Scanner scanner = new Scanner(str);
		Map<Integer, String> tokenMap = new HashMap();
		int tokenId = 0;
		while(scanner.hasNextLine()){
			//int tokenId = 0;
			Scanner sline = new Scanner(scanner.nextLine());
			sline.useDelimiter(delimiter);
			while(sline.hasNext()){
				tokenMap.put(++tokenId, sline.next().trim());
			}
		}
		return tokenMap;
	}

	public static List listTokenize(String str, String delimiter){
		Scanner scanner = new Scanner(str);
		List list = new Vector();
		while(scanner.hasNextLine()){
			Scanner sline = new Scanner(scanner.nextLine());
			sline.useDelimiter(delimiter);
			while(sline.hasNext()){
				list.add(sline.next().trim());
			}
		}
		return list;
	}
}