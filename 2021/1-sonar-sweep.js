module.exports = {
	countDepthIncreases,
}

function countDepthIncreases(depthMeasurements) {
	const measurement = depthMeasurements.shift();
	return countDepthIncreasesRecursive(depthMeasurements, measurement, 0);
}

function countDepthIncreasesRecursive(depthMeasurements, previousMeasurement, increases) {
	if (depthMeasurements.length === 0) {
		return increases;
	}

	const measurement = depthMeasurements.shift();
	if (measurement > previousMeasurement) {
		increases++;
	}
	return countDepthIncreasesRecursive(depthMeasurements, measurement, increases);
}