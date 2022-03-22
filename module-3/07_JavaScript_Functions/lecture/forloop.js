console.log("It's Tuesday!");

let nums = [-2, -4, -10, -8, -6];
let maxFound;

if (nums.length) {
    maxFound = nums[0];
}

for(let num of nums) {
    if (num > maxFound) {
        maxFound = num;
    }
}

console.log(`The maximum value is ${maxFound}`);


//Shadowing -- DON'T DO THIS!
if (true) {
    let i = 5;

    if (true) {
        let i = 7;
        console.log(i);
    }

    console.log(i);
}