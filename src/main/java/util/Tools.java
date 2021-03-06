package util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;

/**
 * @author 濃霧-遠方
 */
public class Tools {

	public String split(String str) {
		String [] strArray = str.split(" ");
		return strArray[0];
	}
	
	public void setSelectedItem(JComboBox<String> box,String item) {
		for(int i = 0; i < box.getItemCount(); i++) {
			if(item.equals(split(box.getItemAt(i)+""))) {
				box.setSelectedIndex(i);
			}
		}
	}
	
	public String getNowTime() {	
			Date date = new Date();
			String nowTime = String.format("%tF", date);
			return nowTime;
	}
	
	public List<String> splitEnumValue(String value) {
		List<String> enumValue = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		int m=0;
		for(int i = 0; i < value.length(); i++) {
			if(value.charAt(i) == '\'' && m==0) {
				m=1;
			}else if(value.charAt(i) == '\'' && m==1) {
				enumValue.add(sb.toString());
				sb.delete(0, sb.length());
				m=0;
			}else {
				if(m==1) {
					sb.append(value.charAt(i));
				}
			}
		}
		return enumValue;
	}
	
	public static void main(String[] argv) {
		Tools tool = new Tools();
		tool.getNowTime();
	}
}
