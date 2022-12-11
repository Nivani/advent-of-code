export function findElfWithMostCalories(input) {
	const elves = parseElves(input);

	let elfWithMostCalories = elves[0];
	for (let i=1; i < elves.length; i++) {
		const elf = elves[i];
		if (elf.totalCalories > elfWithMostCalories.totalCalories) {
			elfWithMostCalories = elf;
		}
	}

	return elfWithMostCalories;
}

function parseElves(input) {
	const elves = [];

	const lines = input.split("\n").map(line => line.trim());
	let elfNumber = 0;
	let latestElf = undefined;
	lines.forEach(line => {
		if (line.length > 0) {
			if (!latestElf) {
				elfNumber++;
				const elf = {
					elfNumber,
					totalCalories: 0,
				};
				elves.push(elf);
				latestElf = elf;
			}
			latestElf.totalCalories += parseInt(line, 10);
		} else {
			latestElf = undefined;
		}
	});

	return elves;
}