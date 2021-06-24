package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrincessessPath {

	public static void main(String[] args) {

		int arr [] = {2,1,2,0,2,-1};
		// int arr[] = { 2, 4, 3, 0, -1, -1 };
		// int arr [] = {2,10,1,-1,1,-2};
		// int arr [] = {2,10,2,1,1,-2};
		//int arr[] = { 5, 1, 2, 0, 2, -1 };
		List<Integer> listOfSteps = new ArrayList<>();
		int loop = findLoop(arr, listOfSteps);
		switch (loop) {
		case 0:
			System.out.println("0 Zombie");
			break;
		case -1:
			System.out.println("-1 Infinite Loop");
			break;

		case 2:
			printTheSteps(listOfSteps);
			break;

		}

	}

	private static void printTheSteps(List<Integer> listOfSteps) {

		listOfSteps.stream().forEach(System.out::println);
		System.out.println("Treasure");

	}

	private static int findLoop(int[] arr, List<Integer> listOfSteps) {

		int curPos = 0;
		int returnValue = 2;
		

		HashMap<Integer, Integer> hm = new HashMap<>();
		while (arr[curPos] < 0 || curPos < arr.length) {
			listOfSteps.add(arr[curPos]);
			int nextPos = curPos + arr[curPos];
			if (nextPos > arr.length - 1)
				return returnValue;

			int nextValue = arr[nextPos];
			if (nextValue == -arr[curPos]) {
				returnValue = -1;
				break;
			} else if (nextValue == 0) {
				returnValue = 0;
				break;
			} else if (nextValue < 0) {
				hm.put(nextPos, hm.getOrDefault(nextPos, 0) + 1);
				if (hm.get(nextPos) > 3) {
					returnValue = -1;
					break;
				}
			}

			curPos = nextPos;
		}

		return returnValue;

	}

}
