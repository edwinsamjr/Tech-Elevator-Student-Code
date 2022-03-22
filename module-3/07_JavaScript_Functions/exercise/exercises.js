/**
 * Write a function called isAdmitted. It will check entrance
 * scores and return true if the student is admitted and
 * false if rejected. It takes three parameters:
 *
 *     * gpa
 *     * satScore (optional)
 *     * recommendation (optional)
 *
 * Admit them--return true--if:
 * gpa is above 4.0 OR
 * SAT score is above 1300 OR
 * gpa is above 3.0 and they have a recommendation OR
 * SAT score is above 1200 and they have a recommendation
 * OTHERWISE reject it
 *
 * @param {number} gpa the GPA of the student, between 4.2 and 1.0
 * @param {number} [satScore=0] the student's SAT score
 * @param {boolean} [recommendation=false] does the student have a recommendation
 * @returns {boolean} true if they are admitted
 */
function isAdmitted(gpa, satScore = 0, recommendation = false) {
    if (gpa > 4.0 || satScore > 1300) {
        return true;
    } else if (gpa > 3.0 && recommendation){
        return true;
    } else if (satScore > 1200 && recommendation) {
        return true;
    } else {
        return false;
    }
}

/**
 * Write a function called useParameterToFilterArray that takes a
 * function and uses that in the `unfilteredArray` filter function. Return the result.
 *
 * @param {function} filterFunction the function to filter with
 * @returns {number[]} the filtered array
 */

let unfilteredArray = [1, 2, 3, 4, 5, 6];

function useParameterToFilterArray(filterFunction) {
    if (!filterFunction) {
        return unfilteredArray;
    }
    
    return unfilteredArray.filter((value) => filterFunction(value));
}

/**
 * Write a function called makeNumber that takes two strings
 * of digits, concatenates them together, and returns
 * the value as a number.
 *
 * So if two strings are passed in "42293" and "443", then this function
 * returns the number 42293443.
 *
 * @param {string} first the first string of digits to concatenate
 * @param {string} [second=''] the second string of digits to concatenate
 * @returns {number} the resultant number
 */
function makeNumber(first, second) {
    combinedString = first + second;

    return parseInt(combinedString);
}

/**
 * Write a function called addAll that takes an unknown number of parameters
 * and adds all of them together. Return the sum.
 *
 * @param {...number} num a series of numbers to add together
 * @returns {number} the sum of all the parameters (or arguments)
 */
function addAll() {
    sum = 0;
    for (let param of arguments) {
        sum += param;
    }

    return sum;
}

/*
 * Write and document a function called makeHappy that takes
 * an array and prepends 'Happy ' to the beginning of all the
 * words and returns them as a new array. Use the `map` function.
 */

/**
 * Takes an array of strings and returns a new array with 'Happy '
 * added to the beginning of each string.
 * of each string.
 * 
 * @param {string[]} array to transform
 * @returns (string[]) array with 'Happy ' prepended to each string
 */
function makeHappy(array) {
    return array.map(value => 'Happy '+ value);
}

/*
 * Write and document a function called getFullAddressesOfProperties
 * that takes an array of JavaScript objects. Each object contains the
 * following keys:
 *     * streetNumber
 *     * streetName
 *     * streetType
 *     * city
 *     * state
 *     * zip
 *
 * Return an array of strings that turns the JavaScript objects
 * into a mailing address in the form of:
 *     streetNumber streetName streetType city state zip
 *
 * Use `map` and an anonymous function.
 */

/**
 * Takes an array of address objects and return an array of strings
 * which are each address written as one line.
 * 
 * @param {object[]} addressesArray 
 * @returns (string[]) mailing addresses in the form of:
 *      streetNumber streetName streetType city state zip
 */
function getFullAddressesOfProperties(addressesArray) {
    let result = addressesArray.map(
        value => 
            value.streetNumber + ' ' +
            value.streetName + ' ' +
            value.streetType + ' ' +
            value.city + ' ' +
            value.state + ' ' +
            value.zip
    );

    return result;

    
    
}

/*
 * Write and document a function called findLargest.
 *
 * Using `forEach`, find the largest element in an array.
 * It must work for strings and numbers.
 */

/**
 * Takes an array of strings or an array of numbers. When given an array of strings,
 * the last string alphabetically is returned. When given an array of numbers,
 * the highest number is returned.
 * 
 * @param {string[] or number[]} array
 * @returns {string or number} largest number in array or last string alphabetically
 */
function findLargest(array) {
    if (array.length === 0) {
        return 0;
    }
    
    
    let maxNum = array[0];

    
        array.forEach((value) => {
            if(value > maxNum) {
                maxNum = value;
            }
        })

    return maxNum;
    
}

/*
 * CHALLENGE
 * Write and document a function called getSumOfSubArrayValues.
 *
 * Take an array of arrays, adds up all sub values, and returns
 * the sum. For example, if you got this array as a parameter:
 * [
 *   [1, 2, 3],
 *   [2, 4, 6],
 *   [5, 10, 15]
 * ];
 *
 * The function returns 48. To do this, you will use two nested `reduce`
 * calls with two anonymous functions.
 *
 * Read the tests to verify you have the correct behavior.
 */

function getSumOfSubArrayValues(array) {
    if (!array || array.length === 0) {
        return 0;
    }
    
    let sum = 
        array.reduce((prevVal, currentSubArray) => {
            return prevVal + sumArray(currentSubArray)

        }, 0);

    


    return sum;

}

function sumArray(array) {
    return array.reduce((prevVal,curVal) => {return prevVal + curVal}, 0);
}