/*
1. **iqTest** Bob is preparing to pass an IQ test. The most frequent task in this test 
    is to find out which one of the given numbers differs from the others. Bob observed
    that one number usually differs from the others in evenness. Help Bob — to check his 
    answers, he needs a program that among the given numbers finds one that is different in 
    evenness, and return the position of this number. _Keep in mind that your task is to help 
    Bob solve a real IQ test, which means indexes of the elements start from 1 (not 0)_

		iqTest("2 4 7 8 10") → 3 //third number is odd, while the rest are even
		iqTest("1 2 1 1") → 2 // second number is even, while the rest are odd
		iqTest("") → 0 // there are no numbers in the given set
        iqTest("2 2 4 6") → 0 // all numbers are even, therefore there is no position of an odd number
*/

function iqTest(numsString){
    const numsArray = numsString.split(' ');
    
    if (numsArray.length < 3) {
        return 0;
    } else if (hasSameNumOfEvensAndOdds(numsString)) {
        return 0;
    } else if (hasMoreEvens(numsString)) {
        let hasReturnedValue = false;
        for (let i = 0; i < numsArray.length; i++) {
            if (parseInt(numsArray[i]) % 2 == 1) {
                return i + 1;
            }
        }
        if (!hasReturnedValue) {
            return 0;
        }

    } else if (!hasMoreEvens(numsString)) {
        let hasReturnedValue = false;
        for (let i = 0; i < numsArray.length; i++) {
            if (parseInt(numsArray[i]) % 2 == 0) {
                return i + 1;
            }
        }

        if (!hasReturnedValue) {
            return 0;
        }

    } else {
        return 0;
    }
}

function hasMoreEvens(numsString) {
    let hasMoreEvens = false;
    const numsArray = numsString.split(' ');


    let numOdds = 0;
    let numEvens = 0;

    for(let i = 0; i < numsArray.length; i++) {
        if (numsArray[i] % 2 == 1) {
            numOdds++;
        } else {
            numEvens++;
        }
    }

    if (numEvens > numOdds) {
        hasMoreEvens = true;
    }

    return hasMoreEvens;
}

function hasSameNumOfEvensAndOdds(numsString) {
    let hasSameNumOfEvensAndOdds = false;
    const numsArray = numsString.split(' ');

    let numOdds = 0;
    let numEvens = 0;

    for(let i = 0; i < numsArray.length; i++) {
        if (numsArray[i] % 2 == 1) {
            numOdds++;
        } else {
            numEvens++;
        }
    }

    if (numEvens == numOdds) {
        hasSameNumOfEvensAndOdds = true;
    }

    return hasSameNumOfEvensAndOdds;
}



/*
2. **titleCase** Write a function that will convert a string into title case, given an optional 
    list of exceptions (minor words). The list of minor words will be given as a string with each 
    word separated by a space. Your function should ignore the case of the minor words string -- 
    it should behave in the same way even if the case of the minor word string is changed.


* First argument (required): the original string to be converted.
* Second argument (optional): space-delimited list of minor words that must always be lowercase
except for the first word in the string. The JavaScript tests will pass undefined when this 
argument is unused.

		titleCase('a clash of KINGS', 'a an the of') // should return: 'A Clash of Kings'
		titleCase('THE WIND IN THE WILLOWS', 'The In') // should return: 'The Wind in the Willows'
        titleCase('the quick brown fox') // should return: 'The Quick Brown Fox'
*/


function titleCase(title, minorWords) {
    let result = '';

    let titleWordsArray = title.split(' ');

    if (!minorWords) {
        for (let i = 0; i <titleWordsArray.length; i++) {
            let isFinalWord = i == titleWordsArray.length - 1;
            let capitalizedWord = capitalizeWord(titleWordsArray[i]);

            if (isFinalWord) {
                result += capitalizedWord;
            } else {
                result += capitalizedWord + ' ';
            }

        }

        return result;
    }


    
    const minorWordsArray = minorWords.split(' ');
    const minorWordsUpperCaseArray = minorWordsArray.map(string => string.toUpperCase());


    for (let i = 0; i <titleWordsArray.length; i++) {
        let isFirstWord = i == 0;
        let isFinalWord = i == titleWordsArray.length - 1;
        let isMinorWord = minorWordsUpperCaseArray.indexOf(titleWordsArray[i].toUpperCase()) != -1;

        let capitalizedWord = capitalizeWord(titleWordsArray[i]);

        if (isFirstWord && isFinalWord) {
            result += capitalizedWord;
        } else if (isFirstWord && !isFinalWord) {
            result += capitalizedWord + ' '; 
        } else if (isMinorWord && isFinalWord) {
            result += titleWordsArray[i].toLowerCase();
        } else if (isMinorWord && !isFinalWord) {
            result += titleWordsArray[i].toLowerCase() + ' ';
        } else if (!isMinorWord && isFinalWord) {
            result += capitalizedWord;
        } else if (!isMinorWord && !isFinalWord) {
            result += capitalizedWord + ' '; 
        }
        
    }

    return result;

}

function capitalizeWord(word) {
    let firstLetter = word.charAt(0).toUpperCase();
    let restOfWord = word.substring(1).toLowerCase();

    return firstLetter + restOfWord;
}