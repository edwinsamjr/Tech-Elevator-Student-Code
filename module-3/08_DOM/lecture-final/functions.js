function sayHello() {
    console.log('Hello');
}

function sayGoodbye() {
    console.log('Goodbye');
}

function saySomething(sayFunction) {
    sayFunction();
}

saySomething(sayHello);
saySomething(sayGoodbye);

let nums = [1,2,3];
nums.forEach(value => {console.log(value)});
nums.forEach(sayHello);

let people = [
    {
        fName: "Dave",
        lName: "Hoy"
    },
    {
        fName: "Shelley",
        lName: "Hoy"
    }
];

let peopleStrs = [];
people.forEach(value => { 
    let peopleStr = `${value.lName}, ${value.fName}`;
    peopleStrs.push(peopleStr);
});
console.log(peopleStrs);
