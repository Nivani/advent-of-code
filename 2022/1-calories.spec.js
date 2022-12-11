import { findElfWithMostCalories, totalCaloriesOfTopElves } from './1-calories';

const exampleInput = `
	1000
	2000
	3000
	
	4000
	
	5000
	6000
	
	7000
	8000
	9000
	
	10000
`;

describe('findElfWithMostCalories()', () => {
	it('returns the elf with the most calories for the example input', () => {
		const { elfNumber, totalCalories } = findElfWithMostCalories(exampleInput);

		expect(elfNumber).toBe(4);
		expect(totalCalories).toBe(24000);
	});
});

describe('findElvesWithMostCalories()', () => {
	it('returns the correct total calories for the top 3 elves of the example input', () => {
		const totalCalories = totalCaloriesOfTopElves(exampleInput, 3);

		expect(totalCalories).toBe(45000);
	});
});
