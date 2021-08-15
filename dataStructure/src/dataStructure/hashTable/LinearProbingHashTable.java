package dataStructure.hashTable;

public class LinearProbingHashTable {

	public Slot[] hashTable;
	
	public LinearProbingHashTable(Integer size) {
		this.hashTable = new Slot[size];
	}
	
	public class Slot {
		String key;
		String value;
		Slot(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public int hashFunc(String key) {
		return (int)(key.charAt(0))%this.hashTable.length;
	}
	
	public boolean saveData(String key, String value) {
		Integer address = this.hashFunc(key);
		if(this.hashTable[address] != null) {
			if(this.hashTable[address].key == key) {
				this.hashTable[address].value = value;
				return true;
			}else {
				Integer curAddress = address + 1;
				while(this.hashTable[curAddress] != null) {
					if(this.hashTable[curAddress].key == key) {
						this.hashTable[curAddress].value = value;
						return true;
					}else {
						curAddress++;
						if(this.hashTable.length <= curAddress) {
							return false;
						}
					}
				}
				this.hashTable[curAddress] = new Slot(key, value);
				return true;
			}
		}else {
			this.hashTable[address] = new Slot(key, value);
		}
		return true;
	}
	
	
	public String getData(String key) {
		Integer address = this.hashFunc(key);
		if(this.hashTable[address] != null) {
			if(this.hashTable[address].key == key) {
				return this.hashTable[address].value;
			}else {
				Integer curAddress = address + 1;
				while(this.hashTable[curAddress] != null) {
					if(this.hashTable[curAddress].key == key) {
						return this.hashTable[curAddress].value;
					}else {
						curAddress++;
						if(this.hashTable.length <= curAddress) {
							return null;
						}
					}
				}
				return null;
			}
		}else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		LinearProbingHashTable ht = new LinearProbingHashTable(20);
		ht.saveData("buzz", "01011111111");
		ht.saveData("Andy", "01022222222");
		ht.saveData("woody", "01033333333");
		ht.saveData("budy", "01044444444");
		System.out.println(ht.getData("buzz"));
		System.out.println(ht.getData("budy"));

	}

}