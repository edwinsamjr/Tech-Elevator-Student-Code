let nestedArray = [
    [1, 2],
    [3, 4],
    [5, 6, 7]
];


function sumArray(arrayToSum) {
    return arrayToSum.reduce((prevVal, curVal) => { 
        return prevVal + curVal
    });
}

//console.log(sumArray([1,2,3]));

function sumArrayOfArrays(arraysToSum) {
    return arraysToSum.reduce((prevVal, curVal) => prevVal + sumArray(curVal), 0);
}

function sumArrayOfArrays(arraysToSum) {
    return arraysToSum.reduce((prevVal, curVal) => prevVal + 
        curVal.reduce((prevValInner, curValInner) => prevValInner + curValInner), 0);
}

console.log(sumArrayOfArrays(nestedArray));