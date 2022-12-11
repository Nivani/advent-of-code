import { readFileSync } from 'node:fs';
import { findElfWithMostCalories } from './1-calories';

const input = readFileSync('./1-calories.input.txt').toString()
const elfWithMostCalories = findElfWithMostCalories(input);

console.log(`Elf number ${elfWithMostCalories.elfNumber} has most calories: ${elfWithMostCalories.totalCalories}`);
