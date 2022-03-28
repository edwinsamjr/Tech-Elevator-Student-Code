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
function strToLowercaseWords(wordStr) {
    return wordStr.split(' ').map((word) => word.toLowerCase());
}

function isMinorWord(wordToCheck, minorWords) {
    return minorWords.includes(wordToCheck);
}

function titlecaseWord(word) {
    return word.substring(0, 1).toUpperCase() + word.substring(1);
}

function titleCase(title, minor = '') {
    let titleWords = strToLowercaseWords(title);
    let minorWords = strToLowercaseWords(minor);

    //let result = '';

    return titleWords.reduce((titleSoFar, titleWord, idx, origArray) => {
        //console.log(`${titleSoFar} ${titleWord} ${idx}`);
        if (idx == 0 || !isMinorWord(titleWord, minorWords)) {
            titleSoFar += titlecaseWord(titleWord);
        } else {
            titleSoFar += titleWord;
        }
        
        if (idx != origArray.length - 1) {
            titleSoFar += ' ';
        }

        return titleSoFar;
    }, '');

    //return result.trim();
}

// 
// Change reduce to map then join
//
function titleCase(title, minor = '') {
    let titleWords = strToLowercaseWords(title);
    let minorWords = strToLowercaseWords(minor);
    
    return titleWords.map((titleWord, idx) => {
        if (idx == 0 || !isMinorWord(titleWord, minorWords)) {
            return titlecaseWord(titleWord);
        } else {
            return titleWord;
        }
    }, '').join(' ');
}

//
// Replaced named methods with the actual code.
//
// Simplified logic to create titleWords and minorWords
//
function titleCase(title, minor = '') {
    let titleWords = title.toLowerCase().split(' ');
    let minorWords = minor.toLowerCase().split(' ');

    return titleWords.map((titleWord, idx) => {
        if (idx == 0 || !minorWords.includes(titleWord)) {
            return titleWord.substring(0,1).toUpperCase() + titleWord.substring(1);
        } else {
            return titleWord;
        }
    }, '').join(' ');

}

console.log(`${titleCase('a clash of KINGS', 'a an the of')}`);
console.log(`${titleCase('THE WIND IN THE WILLOWS', 'The In')}`);
console.log(`${titleCase('the quick brown fox')}`);
