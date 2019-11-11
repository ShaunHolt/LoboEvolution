package org.loboevolution.html.js.geolocation;

import org.loboevolution.js.AbstractScriptableDelegate;

/**
 * <p>The <code>CoordinatesImpl</code> class provides Java implementation of the 
 * "CoordinatesImpl Interface" as detailed out in the W3C Specifications (
 * <a href="http://www.w3.org/TR/geolocation-API/#coordinates_interface">
 * http://www.w3.org/TR/geolocation-API/#coordinates_interface</a>).</p>
 *  
 * <p><b>Note: This class must not have any sub-classes to ensure W3C Specifications are being 
 * strictly followed by the system or application that uses this geolocation package.</b></p>
 */
public class Coordinates extends AbstractScriptableDelegate {
	
	/*
	 * The latitude and longitude attributes are geographic coordinates specified 
	 * in decimal degrees.
	 */
    private double latitude, longitude; 
    
    /*
     * The altitude attribute denotes the height of the position, specified in meters 
     * above the [WGS84] ellipsoid.
     */
    private Double altitude; 
    
    /*
     * The accuracy attribute denotes the accuracy level of the latitude and longitude 
     * coordinates. It is specified in meters and must be supported by all 
     * implementations.
     */
    private double accuracy; 
    
    /*
     * The altitudeAccuracy attribute is specified in meters.
     */
    private Double altitudeAccuracy; 
    
    /*
     * The heading attribute denotes the direction of travel of the hosting device and 
     * is specified in degrees, where 0 <= heading < 360, counting clockwise relative to 
     * the true north.
     */
    private Double heading; 
    
    /*
     * The speed attribute denotes the magnitude of the horizontal component of the hosting 
     * device's current velocity and is specified in meters per second.
     */
    private Double speed;
    
    /**
     * Constructs a <code>org.w3c.geolocation.Coordinates</code> object with the specified 
     * attributes.
     * 
     * @param latitude	the latitude value.
     * @param longitude	the longitude value.
     * @param altitude	the altitude value. It must either be <code>null</code> or a non-negative 
     * real number.
     * @param accuracy	the accuracy of the longitude and latitude. It should correspond to 
     * at least 95% confidence.
     * @param altitudeAccuracy	the accuracy of the altitude. If the implementation cannot provide 
     * altitude information, the value of this attribute must be null. Otherwise, it must be a 
     * non-negative real number.
     * @param heading	where the object is heading. This attribute must be >= 0 or < 360, counting 
     * clockwise relative to the true north. If the implementation cannot provide heading information, 
     * the value of this attribute must be null. If the hosting device is stationary (i.e. the value 
     * of the speed attribute is 0), then the value of this attribute must be NaN.
     * @param speed	speed of the object. If the implementation cannot provide speed information, the 
     * value of this attribute must be null. Otherwise, the value must be a non-negative real number.
     * @throws java.lang.IllegalArgumentException	if any of the above provided arguments fall 
     * outside the specified ranges as mentioned in the W3C Specifications (and also listed above).
     */
    public Coordinates(final double latitude, final double longitude, final Double altitude, 
    		final double accuracy, final Double altitudeAccuracy, final Double heading, final Double speed) 
    		throws IllegalArgumentException {
        // The value of the accuracy attribute must be a non-negative real number.
    	if (accuracy < 0) {
    		throw new IllegalArgumentException("Accuracy cannot be negative.");
    	}
    	
    	/*
    	 * If the implementation cannot provide altitude information, the value of altitudeAccuracy 
    	 * must be null. Otherwise, the value of the altitudeAccuracy attribute must be a 
    	 * non-negative real number.
    	 */
    	if (altitude == null && altitudeAccuracy != null) {
    		throw new IllegalArgumentException("Altitude Accuracy must be set to null because no " +
    				"altitude informration has been provided.");
    	}
    	if (altitude != null && altitudeAccuracy == null) {
    		throw new IllegalArgumentException("Altitude Accuracy cannot be null.");
    	}
    	if (altitude != null && altitudeAccuracy != null && altitudeAccuracy.doubleValue() < 0) {
    		throw new IllegalArgumentException("Altitude Accuracy cannot be negative.");
    	}

    	/*
    	 * The accuracy and altitudeAccuracy values returned by an implementation should correspond 
    	 * to a 95% confidence level.
    	 */
    	if (accuracy/latitude > 0.05 || accuracy/longitude > 0.05) {
    		throw new IllegalArgumentException("Accuracy cannot be less than 95%.");
    	}
    	if (altitude != null && altitudeAccuracy != null && 
    			altitudeAccuracy.doubleValue()/altitude.doubleValue() > 0.05) {
    		throw new IllegalArgumentException("Altitude Accuracy cannot be less than 95%.");
    	}
    	
    	/*
    	 * 0 <= heading < 360, counting clockwise relative to the true north. If the implementation 
    	 * cannot provide heading information, the value of this attribute must be null. If the hosting 
    	 * device is stationary (i.e. the value of the speed attribute is 0), then the value of the 
    	 * heading attribute must be NaN.
    	 */
    	if (heading != null && (heading.doubleValue() < 0 || heading.doubleValue() >= 360)) {
    		throw new IllegalArgumentException("If provided, heading must be >= 0 and < 360.");
    	}
    	if (speed != null && speed.doubleValue() == 0 && heading != null && !heading.isNaN()) {
    		throw new IllegalArgumentException("heading must not have any numeric value because speed is zero.");
    	}
    	
    	/*
    	 * If the implementation cannot provide speed information, the value of this attribute must be 
    	 * null. Otherwise, the value of the speed attribute must be a non-negative real number.
    	 */
    	if (speed != null && speed.doubleValue() < 0) {
    		throw new IllegalArgumentException("If provided, speed cannot be less than zero.");
    	}
    	
    	this.latitude = latitude;
    	this.longitude = longitude;
    	this.accuracy = accuracy;
    	this.altitudeAccuracy = altitudeAccuracy;
    	this.heading = heading;
    	this.speed = speed;
    }

    /**
     * Returns the latitude that was passed to the constructor.
     * 
     * @return	the latitude.
     */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Returns the longitude that was passed to the constructor.
	 * 
	 * @return	the longitude.
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Returns the altitude that was passed to the constructor.
	 * 
	 * @return	the altitude.
	 */
	public Double getAltitude() {
		return altitude;
	}

	/**
	 * Returns the accuracy that was passed to the constructor.
	 * 
	 * @return	the accuracy.
	 */
	public double getAccuracy() {
		return accuracy;
	}

	/**
	 * Returns the altitude accuracy that was passed to the constructor.
	 * 
	 * @return	the altitude accuracy.
	 */
	public Double getAltitudeAccuracy() {
		return altitudeAccuracy;
	}

	/**
	 * Returns the heading that was passed to the constructor.
	 * 
	 * @return the heading.
	 */
	public Double getHeading() {
		return heading;
	}

	/**
	 * Returns the speed that was passed to the constructor.
	 * 
	 * @return the speed.
	 */
	public Double getSpeed() {
		return speed;
	}
}
