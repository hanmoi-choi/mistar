//
//  FirstViewController.h
//  Tab App
//
//  Created by Hanmoi Choi on 1/01/13.
//  Copyright (c) 2013 edu.unimelb.csse. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <CoreLocation/CoreLocation.h>

@interface FirstViewController : UIViewController <CLLocationManagerDelegate>
@property (weak, nonatomic) IBOutlet UITextView *rawDataView;
@property (strong, nonatomic) CLLocationManager* locationManager;

- (IBAction)startDataRetrieve;
- (IBAction)stopDataRetrieve:(id)sender;

@end
