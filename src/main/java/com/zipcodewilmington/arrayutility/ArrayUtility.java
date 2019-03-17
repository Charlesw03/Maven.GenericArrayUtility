package com.zipcodewilmington.arrayutility;

import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    T[] genArr;

    public ArrayUtility(T[] genArr) {
        this.genArr = genArr;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T value) {

        genArr = mergeArrays(arrayToMerge);
        return getNumberOfOccurrences(value);
    }


    public T[] mergeArrays(T[] arrayToMerge) {

        T[] answerArr = Arrays.copyOf(genArr, genArr.length + arrayToMerge.length);

        for (int i = 0; i < genArr.length; i++) {
            answerArr[i] = genArr[i];

        }
        for (int i = genArr.length, j = 0; j < arrayToMerge.length; i++, j++) {
            answerArr[i] = arrayToMerge[j];
        }
        return answerArr;
    }


    public Integer getNumberOfOccurrences(T object) {
        int counter = 0;
        for (T thing : genArr) {
            if (thing == object) {
                counter++;

            }
        }
        return counter;

    }

    public T[] removeValue(T object) {

        Integer index = 0;
        T[] whatyaNeedtoReturn = Arrays.copyOf(genArr, genArr.length - getNumberOfOccurrences(object));
        for (int i = 0; i < genArr.length; i++) {
            if (genArr[i] != object) {
                whatyaNeedtoReturn[index] = genArr[i];
                index++;
            }
        }
        return whatyaNeedtoReturn;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        Integer counter = 0;
        T mostCommonThing = null;
        T[] aTArray = mergeArrays(arrayToMerge);
        for (T thing : aTArray) {
            if (getNumberOfOccurrences(thing) > counter) {
                counter = getNumberOfOccurrences(thing);
                mostCommonThing = thing;

            }
        }
        return mostCommonThing;
    }

}

