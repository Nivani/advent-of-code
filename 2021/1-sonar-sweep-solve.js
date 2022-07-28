const { readFileSync } = require('node:fs');
const { countDepthIncreases } = require('./1-sonar-sweep');

const input = readFileSync('./1-input.txt')
	.toString()
	.split('\n')
	.map(s => Number.parseInt(s, 10));
const solution = countDepthIncreases(input, { windowSize: 3 });

console.log('Depth increases', solution, 'times');
