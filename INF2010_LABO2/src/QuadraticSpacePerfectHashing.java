import java.util.ArrayList;
import java.util.Random;

public class QuadraticSpacePerfectHashing<AnyType> {
	static int p = 46337;

	int a, b;
	AnyType[] items;

	QuadraticSpacePerfectHashing() {
		a = b = 0;
		items = null;
	}

	QuadraticSpacePerfectHashing(ArrayList<AnyType> array) {
		AllocateMemory(array);
	}

	public void SetArray(ArrayList<AnyType> array) {
		AllocateMemory(array);
	}

	public int Size() {
		if (items == null)
			return 0;

		return items.length;
	}

	public boolean containsKey(int key) {
		return items[key] != null;
	}

	public boolean containsValue(AnyType x) {
		// A completer
		int decalageQuad = 0;
		int keyDecalage;
		while (true) {
			keyDecalage = getKey(x) + decalageQuad * decalageQuad;
			if (items[keyDecalage] == null) {
				return false;
			} else if (items[keyDecalage].equals(x)) {
				return true;
			} else {
				decalageQuad++;
			}
		}
	}

	public void remove(AnyType x) {
		// A completer
		items[getKey(x)] = null;
	}

	public int getKey(AnyType x) {
		// A completer
		int pls = x.hashCode();
		int key = ((a * x.hashCode() + b) % p) % items.length;
		return key;
	}

	@SuppressWarnings("unchecked")
	private void AllocateMemory(ArrayList<AnyType> array) {
		Random generator = new Random(System.nanoTime());

		if (a == 0 && b == 0) {
			items = (AnyType[]) new Object[array.size() * array.size()];
			a = generator.nextInt(p-1)+1;
			b = generator.nextInt(p-1)+1;
		}
		if (array.size() == 1) {
			a = b = 0;
			// A completer
			return;
		}

		// A completer
		for (int i = 0; i < array.size(); i++) {
			int key = getKey(array.get(i));
			int quadDecalage = 0;
			int keyDecalage = (key + quadDecalage * quadDecalage) % items.length;
			boolean placed = false;
			while (!placed) {
				if (items[keyDecalage] == null) {
					items[keyDecalage] = array.get(i);
					placed = true;
				} else {
					quadDecalage++;
				}
			}

		}

	}

	public String toString() {
		String result = "";
		
		// A completer
		
		return result;
	}

	public void makeEmpty () {
		for(int i = 0; i < items.length; i++ )
			items[ i ] = null;
   	}
}