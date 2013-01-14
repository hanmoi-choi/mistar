//
//  ViewController.m
//  Slider
//
//  Created by Hanmoi Choi on 1/01/13.
//  Copyright (c) 2013 edu.unimelb.csse. All rights reserved.
//

#import "ViewController.h"

@implementation ViewController

@synthesize slider = _slider;
@synthesize label = _label;

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)slideValueChanged:(id)sender {
    float value = [self.slider value];
    NSString* valueString = [NSString stringWithFormat:@"%.2f", value];
    self.label.text = valueString;
}
@end
