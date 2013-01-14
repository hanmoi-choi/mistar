//
//  ViewController.h
//  Slider
//
//  Created by Hanmoi Choi on 1/01/13.
//  Copyright (c) 2013 edu.unimelb.csse. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController
- (IBAction)slideValueChanged:(id)sender;
@property (weak, nonatomic) IBOutlet UISlider *slider;
@property (weak, nonatomic) IBOutlet UILabel *label;

@end
