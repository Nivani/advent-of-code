import { readFileSync } from 'node:fs';
import { findElfWithMostCalories, totalCaloriesOfTopElves } from './1-calories';

const input = readFileSync('./1-calories.input.txt').toString()
const elfWithMostCalories = findElfWithMostCalories(input);

console.log(`Elf number ${elfWithMostCalories.elfNumber} has most calories: ${elfWithMostCalories.totalCalories}`);

const totalCaloriesOfTop3 = totalCaloriesOfTopElves(input, 3);

console.log(`Total calories of top 3 elves is ${totalCaloriesOfTop3}`);
