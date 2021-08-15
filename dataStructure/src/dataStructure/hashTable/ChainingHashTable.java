package dataStructure.hashTable;

public class ChainingHashTable {

	public Slot[] hashTable;
	
	public ChainingHashTable(Integer size) {
		this.hashTable = new Slot[size];
	}
	
	public class Slot {
		String key;
		String value;
		Slot next;
		Slot(String key, String value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
	
	public int hashFunc(String key) {
		return (int)(key.charAt(0))%this.hashTable.length;
	}
	
	public boolean saveData(String key, String value) {
		Integer address = this.hashFunc(key);
		if(this.hashTable[address] != null) {
			Slot findSlot = this.hashTable[address];
			Slot prevSlot = this.hashTable[address];
			while(findSlot != null) {
				if(findSlot.key == key) {
					findSlot.value = value;
					return true;
				}else {
					prevSlot = findSlot;
					findSlot = findSlot.next;
				}
			}
			prevSlot.next = new Slot(key, value);
		}else {
			this.hashTable[address] = new Slot(key, value);
		}
		return true;
	}
	
	
	public String getData(String key) {
		Integer address = this.hashFunc(key);
		if(this.hashTable[address] != null) {
			Slot findSlot = this.hashTable[address];
			while(findSlot.key != null) {
				if(findSlot.key == key) {
					return findSlot.value;
				}else {
					findSlot = findSlot.next;
				}
			}
			return null;
		}else {
			return null;
		}
	}

	
	public static void main(String[] args) {
		ChainingHashTable ht = new ChainingHashTable(20);
		ht.saveData("buzz", "01011111111");
		ht.saveData("Andy", "01022222222");
		ht.saveData("woody", "01033333333");
		ht.saveData("budy", "01044444444");
		System.out.println(ht.getData("buzz"));
		System.out.println(ht.getData("budy"));
	}

}