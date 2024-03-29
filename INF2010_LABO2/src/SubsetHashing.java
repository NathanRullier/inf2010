import java.util.Arrays;
import java.util.HashSet;

public class SubsetHashing {
	
    /* Return true si Tab2 [] est un sous-ensemble de Tab1 [] */
	static boolean isSubset(int Tab1[], int Tab2[], int m, int n)
    {
        // complexite de O(n)
		
		HashSet<Integer> Set1 = new HashSet <> (m);
		HashSet<Integer> Set2 = new HashSet <Integer>(n);
		for(int i = 0; i<m;i++) {
			Set1.add(Tab1[i]);
		}
		for(int i = 0; i<n;i++) {
			Set2.add(Tab2[i]);
		}
        return Set1.containsAll(Set2);
    } 
 
    public static void main(String[] args) 
    { 
        int T1[] = {5, 11, 12, 1, 10, 3, 7};
        int T2[] = {11, 1, 10};
         
        int m = T1.length;
        int n = T2.length;
     
        if(isSubset(T1, T2, m, n))
            System.out.print("Tab2 [] est un sous-ensemble de Tab1 [] ");
        else
            System.out.print("Tab2 [] n'est pas un sous-ensemble de Tab1 []"); 
    }
}


