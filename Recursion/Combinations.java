import java.util.ArrayList;
import java.util.List;

class CSolution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = i + 1;
        }
        System.out.println("array elements :");
        for(int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
        getCombo(0,k,arr,new ArrayList<>(),result);
        return result;
    }

    void getCombo(int index,int k,int[] arr,List<Integer> list,List<List<Integer>> result){
        
        if(list.size() == k){
            result.add(new ArrayList<>(list));
            return ;
        }
        
        if(index >= arr.length){
            return ;
        }
        
        for(int i =index;i<arr.length;i++){
            list.add(arr[i]);
            getCombo(i+1, k, arr, list, result);
            list.remove(list.size()-1);
        }
    }
}

class ComboClass{
    public static void main(String[] args){
        List<List<Integer>> res = new CSolution().combine(5, 2);
        for(List<Integer> list : res){
            for(int i : list){
                System.out.print(i+" ");
            }
            System.out.println("");
        } 
    }
}