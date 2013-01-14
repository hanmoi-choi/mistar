//
//  FaceView.h
//  Happiness
//
//  Created by Hanmoi Choi on 2/01/13.
//  Copyright (c) 2013 edu.unimelb.csse. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <UIKit/UIPinchGestureRecognizer.h>

@class FaceView;

@protocol FaceViewDataSource
- (CGFloat) smileForFaceView:(FaceView*)sender;
@end

@interface FaceView : UIView

@property (nonatomic)CGFloat scale;

- (void)pinch:(UIPinchGestureRecognizer*)recognizer;
@property (nonatomic, weak) IBOutlet id<FaceViewDataSource> dataSource;
@end
