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
           T[] genArr = mergeArrays(arrayToMerge);
            return getNumberOfOccurrences(value);
    }

    public T[] mergeArrays(T[] arrayToMerge) {
        T[] answerArr = Arrays.copyOf(genArr, genArr.length + arrayToMerge.length);

        for (int i = 0; i < genArr.length; i++) {
            answerArr[i] = genArr[i];
        }
        for (int j = 0; j < arrayToMerge.length; j++) {
            answerArr[j] = arrayToMerge[j];
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
            whatyaNeedtoReturn[index] = whatyaNeedtoReturn[i];
            index++;
        }
        return whatyaNeedtoReturn;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        Integer counter = 0;
        T mostCommonThing = null;
        T[] answerArray = mergeArrays(arrayToMerge);
        for (T thing : arrayToMerge) {
            if (getNumberOfOccurrences(thing) > counter) {
                counter = getNumberOfOccurrences(mostCommonThing);
                mostCommonThing = thing;

            }
        }
        return mostCommonThing;
    }


}
