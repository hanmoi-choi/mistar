//
//  SecondViewController.m
//  Tab App
//
//  Created by Hanmoi Choi on 1/01/13.
//  Copyright (c) 2013 edu.unimelb.csse. All rights reserved.
//

#import "SecondViewController.h"

@interface SecondViewController ()

@end

@implementation SecondViewController

@synthesize locationManager = _locationManager;
@synthesize geoCoder = _geoCoder;

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    self.geoCoder = [[CLGeocoder alloc] init];
    self.locationManager = [[CLLocationManager alloc] init];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)getGeoCodePressed {
    CLLocation* lastLocation = self.locationManager.location;
    
    if(lastLocation){
        [self.geoCoder reverseGeocodeLocation:lastLocation
                            completionHandler:^(NSArray *placemarks, NSError *error)
        {
            if(placemarks.count > 0){
                CLPlacemark* firstPlaceMark = (CLPlacemark*)[placemarks objectAtIndex:0];
                self.geocodeView.text = [firstPlaceMark description];
            }
            else if(error){
                self.geocodeView.text = [NSString stringWithFormat:@"Error: %@", error];
            }
             
        }];
    }
    else{
        self.geocodeView.text = @"No location data";
    }
    
}
@end
