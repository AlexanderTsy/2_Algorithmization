package by.jonline.algorithmization02.single_dimension_array;

/**
 * 
 * 3. Algorithmization Одномерные массивы. Задание 3<br/>
 * Дан массив действительных чисел, размерность которого N.<br/>
 * Подсчитать, сколько в нем отрицательных, положительных и нулевых элементов.
 *
 * @author tsyhanok.aa
 * 
 */
public class Task3 {
	
	/**
	 * Method calculates number of negative, positive and zero elements in <b>array<b/>
	 * 
	 * @param array	array of real numbers
	 * @return 	arr[0] count of negative<br/>
	 * 			arr[1] count of zeros<br/>
	 * 			arr[2] count of positive
	 */
	public static int[] calculateNegZeroPos(final double[] array){
		int[] result = {0,0,0};
		// Объявим и инициализируем переменные количества элементов
		int countNegative = 0; // отрицательные
		int countZero = 0; // нули
		int countPositive = 0; // положительные

		// подсчитаем количество элементов
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0) {
				countNegative++;
			} else if (array[i] == 0) {
				countZero++;
			} else {
				countPositive++;
			}
		}
		
		result[0] = countNegative;
		result[1] = countZero;
		result[2] = countPositive;
		
		return result;
	}

	public static void main(String[] args) {
		
		int[] result;
		
		/* Для демонстрации работы алгоритма
		 * зададим содержимое массива случайным образом
		 */
		int n = 10000; // размерность массива N
		double[] array = new double[n];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = (Math.random() - 0.5) * 10000;
		}

		// подсчитаем количество элементов
		result = calculateNegZeroPos(array);
		
		System.out.println("Количество отрицательных элементов: " + result[0]);
		System.out.println("Количество нулей: " + result[1]);
		System.out.println("Количество положительных элементов: " + result[2]);
	}

}
