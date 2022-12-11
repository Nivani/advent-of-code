import { findElfWithMostCalories } from './1-calories';

describe('findElfWithMostCalories()', () => {
	it('returns 4th elf, 24000 calories for the example input', () => {
		const input = `1000
2000
3000

4000

5000
6000

7000
8000
9000

10000`;

		const { elfNumber, totalCalories } = findElfWithMostCalories(input);

		expect(elfNumber).toBe(4);
		expect(totalCalories).toBe(24000);
	});
})