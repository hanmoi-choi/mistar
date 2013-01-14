//
//  SecondViewController.h
//  Tab App
//
//  Created by Hanmoi Choi on 1/01/13.
//  Copyright (c) 2013 edu.unimelb.csse. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <CoreLocation/CoreLocation.h>

@interface SecondViewController : UIViewController

@property (strong, nonatomic)CLGeocoder* geoCoder;
@property (strong, nonatomic)CLLocationManager* locationManager;
@property (weak, nonatomic) IBOutlet UITextView *geocodeView;

- (IBAction)getGeoCodePressed;

@end
