module.exports = {
	countDepthIncreases,
}

function countDepthIncreases(depthMeasurements, { windowSize = 1 } = {}) {
	const measurementWindows = calculateWindows(depthMeasurements, windowSize);
	const windowSums = measurementWindows.map(sum);
	return countIncreasesRecursive(windowSums, 0);
}

function calculateWindows(depthMeasurements, windowSize) {
	const windows = [];
	for (let i=0; i <= depthMeasurements.length - windowSize; i++) {
		windows.push(depthMeasurements.slice(i, i + windowSize));
	}
	return windows;
}

function sum(arr) {
	return arr.reduce(
		(sum, val) => sum + val,
		0,
	);
}

function countIncreasesRecursive(values, increases) {
	if (values.length <= 1) {
		return increases;
	}

	const value = values.shift();

	if (values[0] > value) {
		increases++;
	}

	return countIncreasesRecursive(values, increases);
}