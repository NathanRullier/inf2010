import java.util.Random;
import java.util.ArrayList;

public class LinearSpacePerfectHashing<AnyType>
{
	static int p = 46337;

	QuadraticSpacePerfectHashing<AnyType>[] data;
	int a, b;

	LinearSpacePerfectHashing()
	{
		a=b=0; data = null;
	}

	LinearSpacePerfectHashing(ArrayList<AnyType> array)
	{
		AllocateMemory(array);
	}

	public void SetArray(ArrayList<AnyType> array)
	{
		AllocateMemory(array);
	}

	@SuppressWarnings("unchecked")
	private void AllocateMemory(ArrayList<AnyType> array)
	{
		Random generator = new Random( System.nanoTime() );

		if(array == null || array.size() == 0)
		{
			// A completer
			data = new QuadraticSpacePerfectHashing[0];
			return;
		}
		if(array.size() == 1)
		{
			a = b = 0;
			// A completer
			data = new QuadraticSpacePerfectHashing[1];
            data[0] = new QuadraticSpacePerfectHashing<AnyType> (array);
			return;
		}
		// A completer
		a = generator.nextInt(p-1)+1;
		b = generator.nextInt(p-1)+1;
	
		data = new QuadraticSpacePerfectHashing[array.size()];
        ArrayList<AnyType>[] tableau = new ArrayList[array.size()];
        ArrayList<AnyType> list;
        for (int i = 0; i < array.size(); i++) {
            list = new ArrayList();
            tableau[i] = list;
        }
        for (int i = 0; i < array.size(); i++) {
            tableau[getKey(array.get(i))].add(array.get(i));
        }
        for (int i = 0; i < array.size(); i++) {            
            if (!tableau[i].isEmpty()) {
                data[i] = new QuadraticSpacePerfectHashing<AnyType>(tab[i]);
            }
            
        }
    }

	public int Size()
	{
		if( data == null ) return 0;

		int size = 0;
		for(int i=0; i<data.length; ++i)
		{
			size += (data[i] == null ? 1 : data[i].Size());
		}
		return size;
	}

	public boolean containsKey(int key)
	{
		// A completer
		return data[key] != null;
	}
	
	public int getKey (AnyType x) {
		// A completer
		int j = ((a*x.hashCode()+b)%p)%(data.length);
		return j;
	}
	
	public boolean containsValue (AnyType x) {
		// A completer
		boolean result = false;
		if(data[this.getKey(x)] != null) {
			result = data[this.getKey(x)].containsValue(x);
		}
		return result;
	}
	
	public void remove (AnyType x) {
		// A completer
		data[getKey(x)].remove(x);
	}

	public String toString () {
		String result = "";
		// A completer
		for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                result += "[" + i + "] -> ";
                for (int j = 0; j < data[i].Size(); j++) {
                    if (data[i].items[j] != null) {
                        result += "(" + j + ", " + data[i].items[j].toString() + "), ";
                    }
                }
                result = result.substring(0, result.length() - 2);
                result += ".\n";
            }
        }
		return result; 
	}

	public void makeEmpty () {
		// A completer
		for(int i = 0; i < data.length; i++) {
			data[i].makeEmpty();
		}

   	}
	
}
