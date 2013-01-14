//
//  ViewController.h
//  Browser
//
//  Created by Hanmoi Choi on 1/01/13.
//  Copyright (c) 2013 edu.unimelb.csse. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController <UIWebViewDelegate>
@property (weak, nonatomic) IBOutlet UIWebView *webView;
@property (weak, nonatomic) IBOutlet UITextField *urlText;
@property (weak, nonatomic) IBOutlet UIActivityIndicatorView *activityIndicator;
- (IBAction)urlTextDidEditEnd:(id)sender;

@end
