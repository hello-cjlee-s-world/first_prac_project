package programmers_prac;

import java.util.ArrayList;
import java.util.List;

public class ListExam {
	public static void main(String[] args) {
		List<String> lst = new ArrayList<>();
		lst.add("kim");
		lst.add("kang");
		lst.add("kim");
		
		System.out.println(lst.size());
		for(int i=0; i<lst.size(); i++) {
			System.out.println(lst. get(i));
		}
		for(String s : lst) {
			System.out.println(s);
		}
	}
}
