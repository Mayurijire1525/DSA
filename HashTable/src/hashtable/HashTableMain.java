package hashtable;

class HashTable{
	static class Pair{
		private int key;//key=roll
		private String value;//value=name
		public Pair() {
			 key=0;
			 value="";
		}
		public Pair(int key,String value) {
			key=key;
			value=value;
		}
		@Override
		public String toString() {
			return "Pair [key=" + key + ", value=" + value + "]";
		}
		
	}
}
public class HashTableMain {

}
