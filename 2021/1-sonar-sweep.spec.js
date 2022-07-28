const { countDepthIncreases } = require('./1-sonar-sweep');

describe('2021', () => {
	describe('Day 1: Sonar Sweep', () => {
		it('handles the example correctly', () => {
			const input = [199, 200, 208, 210, 200, 207, 240, 269, 260, 263];
			expect(countDepthIncreases(input)).toBe(7);
		});

		it('handles the example correctly with a sliding windows of 3', () => {
			const input = [199, 200, 208, 210, 200, 207, 240, 269, 260, 263];
			expect(countDepthIncreases(input, { windowSize: 3 })).toBe(5);
		});
	});
});
