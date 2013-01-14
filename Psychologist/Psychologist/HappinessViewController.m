//
//  ViewController.m
//  Happiness
//
//  Created by Hanmoi Choi on 2/01/13.
//  Copyright (c) 2013 edu.unimelb.csse. All rights reserved.
//

#import "HappinessViewController.h"
#import "FaceView.h"

@interface HappinessViewController () <FaceViewDataSource>
@property (nonatomic, weak) IBOutlet FaceView* faceView;
@end

@implementation HappinessViewController

@synthesize happiness = _happiness;
@synthesize faceView = _faceView;

-(void) setHappiness:(int)happiness{
    _happiness = happiness;
    [self.faceView setNeedsDisplay];
}

-(void)setFaceView:(FaceView *)faceView {
    _faceView = faceView;
    [self.faceView addGestureRecognizer:[[UIPinchGestureRecognizer alloc] initWithTarget:self.faceView action:@selector(pinch:)]];
    [self.faceView addGestureRecognizer:[[UIPanGestureRecognizer alloc] initWithTarget:self action:@selector(handleHapinessGesture:)]];
    self.faceView.dataSource = self;

}

-(BOOL)shouldAutorotate {
    return YES;
}

-(CGFloat) smileForFaceView:(FaceView *)sender{
    return (self.happiness - 50) / 50.0;
}

- (void) handleHapinessGesture:(UIPanGestureRecognizer*)recognizer{
    
    if((recognizer.state == UIGestureRecognizerStateChanged) ||
       (recognizer.state == UIGestureRecognizerStateEnded)){
        CGPoint translation = [recognizer translationInView:self.faceView];
        self.happiness -= translation.y / 2;
        [recognizer setTranslation:CGPointZero inView:self.faceView];
    }
 
}
@end
