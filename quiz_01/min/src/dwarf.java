class CodeRunner{
	public static void main(String[] args){
        
        int[] result = new int[7];
        int[] arr = {20,7,23,19,10,8,13,15,25};
        
        
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        
        int remainder = sum - 100;
        
        int a = 0;
        int b = 0;
        boolean find = false;
        for (int i = 0; i < arr.length; i++) {
            a = arr[i];
            for (int l = 0; l < arr.length; l++) {
                b = arr[l];
                if(a != b && (a + b) == remainder){
                    find = true;
                    break;
                }
            }
            if (find) {
                break;
            }
        }
        
        int num = 0;
        int temp = 0;
        int lastIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != a && arr[i] != b) {
                num = arr[i];
                for (int l = 0; l < result.length; l++) {
                    if (result[l] == 0) {
                        result[l] = num;
                        lastIndex = l + 1;
                        break;
                    } else if(result[l] > num) {
                        temp = result[l];
                        result[l] = num;
                        num = temp;
                    }
                }
            }
        }
        
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
	}
}
