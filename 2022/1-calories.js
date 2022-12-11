export function findElfWithMostCalories(input) {
	return findElvesWithMostCalories(input, 1)[0];
}

export function totalCaloriesOfTopElves(input, numberOfElves) {
	const elvesWithMostCalories = findElvesWithMostCalories(input, numberOfElves);
	return elvesWithMostCalories.reduce(
		(sum, elf) => sum + elf.totalCalories,
		0,
	);
}

function findElvesWithMostCalories(input, number) {
	return parseElves(input)
		.sort((elf1, elf2) => {
			if (elf1.totalCalories < elf2.totalCalories) {
				return -1;
			} else if (elf1.totalCalories === elf2.totalCalories) {
				return 0;
			} else {
				return 1;
			}
		})
		.slice(parseElves(input).length - number, parseElves(input).length);
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