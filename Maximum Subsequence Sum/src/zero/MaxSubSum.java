package zero;

/**
 * @author liquanshuzero
 *
 * Maximum Subsequence Sum
 * 求最大子序列和的问题
 * four kind of algorithm
 * these algorithm are from Data Structures and Algorithm Analysis in Java (Third Edition) p26-p30
 * but there is a little bug in the firth algorithm, and I have modified it
 * 
 * 2018年5月31日
 */
public class MaxSubSum {
	
	// first algorithm O(N³) , poor efficiency
	// add number by sequence from first,second…… until the last.
	public static int maxSubSum1( int [] a )
	{
		
		int maxSum = 0;
		
		for( int i = 0; i < a.length; i++ )
			for( int j = i; j < a.length; j++ ) 
			{
				int thisSum = 0;
				
				for( int k = i; k <= i; k++ )
					thisSum += a[ k ];
				
				if( thisSum > maxSum )
					maxSum = thisSum;
			}
		
		return maxSum;
	}
	
	// second algorithm O(N²), medium efficiency
	// add number by sequence from first,second…… until the last.
	// this algorithm deletes redundant sentences
	public static int maxSubSum2( int [] a )
	{
		
		int maxSum = 0;
		
		for( int i = 0; i < a.length; i++ )
		{
			int thisSum = 0;
			
			for( int j = i; j < a.length; j++ )
			{
				thisSum += a[ j ];
				
				if( thisSum > maxSum )
					maxSum = thisSum;
			}
		}
		
		return maxSum;
	}
	
	// third algorithm O(NlogN) high efficiency
	// recursion : divide-and-conquer
	//
	// divide the sequence into 3 piece: left 、 middle and right
	// then find the "left MaxSubSum" "right MaxSubSum" and "middle MaxSubSum"
	// "middle MaxSubSum" should include the last element of the left part and the first element of the right part
	// compare them
	private static int maxSubSum3( int [ ] a, int left, int right )
	{
		if( left == right ) // Base case
			if( a[ left ] > 0 )
				return a[ left ];
			else 
				return 0;
		
		int center = ( left + right ) / 2;
		int maxLeftSum = maxSubSum3 ( a, left, center );
		int maxRightSum = maxSubSum3 ( a, center+1, right );
		
		int maxLeftBorderSum = 0, leftBorderSum = 0;
		for( int i = center; i >= left; i-- )
		{
			leftBorderSum += a[ i ];
			if( leftBorderSum > maxLeftBorderSum )
				maxLeftBorderSum = leftBorderSum;
		}
		
		int maxRightBorderSum = 0, rightBorderSum = 0;
		for( int i = center + 1; i <= right; i++ )
		{
			rightBorderSum += a[ i ];
			if( rightBorderSum > maxRightBorderSum )
				maxRightBorderSum = rightBorderSum;
		}
		
		return max3( maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum );
	}
	
	// driver for recursion
	public static int maxSubSum3( int [ ] a )
	{
		return maxSubSum3( a, 0, a.length-1);
	}
	
	//max a,b,c
	public static int max3( int a, int b, int c )
	{
		return (a>b)? ((a>c)? a:c):((b>c)? b:c);
	}
	
	// forth algorithm O(N) higher efficiency
	// one number will add when it adds a plus
	// one number will not change when it adds 0
	// one number will reduce when it adds a negative number
	public static int maxSubSum4 ( int [ ] a )
	{
		int maxSum = a[0], thisSum = a[0];
		
		for( int j = 1; j < a.length; j++)
		{
			thisSum += a[ j ];
			
			if( thisSum > maxSum )
				maxSum = thisSum;
			if( thisSum < 0 )  // the original is "else if( thisSum < 0 )"
				thisSum = 0;
		}
		
		return maxSum;
	}

	public static void main(String[] args) {
		//start your performance
	}
}
