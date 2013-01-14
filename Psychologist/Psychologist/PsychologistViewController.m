//
//  PsychologistViewController.m
//  Psychologist
//
//  Created by Hanmoi Choi on 3/01/13.
//  Copyright (c) 2013 edu.unimelb.csse. All rights reserved.
//

#import "PsychologistViewController.h"
#import "HappinessViewController.h"

@interface PsychologistViewController ()
@property (nonatomic) int diagnosis;
@end

@implementation PsychologistViewController

@synthesize diagnosis = _diagnosis;

- (void) setAndShowDiagnosis:(int)diagnosis{
    self.diagnosis = diagnosis;
    
    //segue
    [self performSegueWithIdentifier:@"ShowDiagnosis" sender:self];
}

- (void) prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender{
    if([segue.identifier isEqualToString:@"ShowDiagnosis"]){
        [segue.destinationViewController setHappiness:self.diagnosis];
    }
}
- (IBAction)flying {
    [self setAndShowDiagnosis:100];
}

- (IBAction)chasing {
    [self setAndShowDiagnosis:20];
}

- (IBAction)reading {
    [self setAndShowDiagnosis:70];
}

@end
